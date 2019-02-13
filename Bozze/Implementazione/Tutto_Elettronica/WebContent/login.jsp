<%

String userRoles =(String)session.getAttribute("userRoles");
String name = (String)session.getAttribute("name");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="OneTech shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
<link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="plugins/slick-1.8.0/slick.css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">
<link rel="stylesheet" type="text/css" href="styles/style.css">
<link rel="stylesheet" type="text/css" href="styles/main_styles.css">
<link rel="stylesheet" type="text/css" href="styles/responsive.css">
<script type="text/javascript" src="js/validation.js"></script>
</head>
<body>

<body>

<div class="super_container">
	
	<!-- Header -->
	
	<header class="header">


		<!-- Header Main -->

		<div class="header_main">
			<div class="container">
				<div class="row">

					<!-- Logo -->
					<div class="col-lg-2 col-sm-3 col-3 order-1">
						<div class="logo_container">
							<div class="logo"><a href="index.jsp">Tutto Elettronica</a></div>
						</div>
					</div>

					<!-- Search -->
					<div class="col-lg-6 col-12 order-lg-2 order-3 text-lg-left text-right">
						<div class="header_search">
							<div class="header_search_content">
								<div class="header_search_form_container">
									<form action="RicercaProdottiControl" class="header_search_form clearfix">
										<input type="search" required="required" class="header_search_input" placeholder="Search for products..." name="search">
										<div class="custom_dropdown">
											<div class="custom_dropdown_list">
												<span class="custom_dropdown_placeholder clc"></span>
												
												<ul class="custom_list clc">
													<li><a class="clc" href="#"></a></li>
													<li><a class="clc" href="#"></a></li>
													<li><a class="clc" href="#"></a></li>
													<li><a class="clc" href="#"></a></li>
													<li><a class="clc" href="#"></a></li>
													<li><a class="clc" href="#"></a></li>
												</ul>
											</div>
										</div>
										<button type="submit" class="header_search_button trans_300" value="Submit"><img src="images/search.png" alt=""></button>
									</form>
								</div>
							</div>
						</div>
					</div>
					
					<!-- Login -->
					<div class="col-lg-4 col-9 order-lg-3 order-2 text-lg-left text-right">
						<div class="wishlist_cart d-flex flex-row align-items-center justify-content-end">
						<%
						if(userRoles == null || userRoles.equals("navigatore")){
						%>
							<div class="wishlist d-flex flex-row align-items-center justify-content-end">
								<div class="wishlist_icon"><img src="images/login.png" alt="" style="height:35px; width:35px;"></div>
								<div class="wishlist_content">
									<div class="wishlist_text"><a href="login.jsp">Login</a></div>
									
								</div>
							</div>
						<%
						}else
							if(userRoles.equals("cliente")){
						%>
						<div class="wishlist d-flex flex-row align-items-center justify-content-end">
								<div class="wishlist_icon"><img src="images/login.png" alt="" style="height:35px; width:35px;"></div>
								<div class="wishlist_content">
									<div class="wishlist_text"><a href="VisualizzaAccountControl">Area Utente</a></div>
									
								</div>
							</div>
							
							<div class="wishlist d-flex flex-row align-items-center justify-content-end">
								<div class="wishlist_icon"><img src="images/logout.png" alt="" style="height:35px; width:35px;"></div>
								<div class="wishlist_content">
									<div class="wishlist_text"><a href="LogoutControl">Logout</a></div>
									
								</div>
							</div>
							
							<!-- Cart -->
							<div class="cart">
								<div class="cart_container d-flex flex-row align-items-center justify-content-end">
									<div class="cart_icon">
										<img src="images/cart.png" alt="" style="height:35px; width:35px;">
									</div>
									<div class="cart_content">
										<div class="cart_text"><a href="cart.jsp">Cart</a></div>
									</div>
								</div>
							</div>
						<%}else{ %>
						<div class="wishlist d-flex flex-row align-items-center justify-content-end">
								<div class="wishlist_icon"><img src="images/logout.png" alt="" style="height:35px; width:35px;"></div>
								<div class="wishlist_content">
									<div class="wishlist_text"><a href="LogoutControl">Logout</a></div>
									
								</div>
							</div>
						<%} %>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Main Navigation -->

		<nav class="main_nav">
			<div class="container">
				<div class="row">
					<div class="col">
						
						<div class="main_nav_content d-flex flex-row">

							<!-- Categories Menu -->

							<div class="cat_menu_container">
								<div class="cat_menu_title d-flex flex-row align-items-center justify-content-start">
									<div class="cat_burger"><span></span><span></span><span></span></div>
									<div class="cat_menu_text">categories</div>
								</div>

								<ul class="cat_menu">
									<li><a href="RicercaCategoriaControl?tipo=batterie">Batterie <i class="fas fa-chevron-right ml-auto"></i></a></li>
									<li><a href="RicercaCategoriaControl?tipo=arduino">Arduino<i class="fas fa-chevron-right"></i></a></li>
									<li><a href="RicercaCategoriaControl?tipo=componenti">Componenti<i class="fas fa-chevron-right"></i></a>
									</li>
									<li><a href="RicercaCategoriaControl?tipo=altoparlanti">Altoparlanti<i class="fas fa-chevron-right"></i></a></li>
									<li><a href="RicercaCategoriaControl?tipo=informatica">Informatica<i class="fas fa-chevron-right"></i></a></li>
									<li><a href="RicercaCategoriaControl?tipo=attrezzatura">Attrezzatura<i class="fas fa-chevron-right"></i></a></li>
									<li><a href="RicercaCategoriaControl?tipo=accessori">Accessori<i class="fas fa-chevron-right"></i></a></li>
									<li><a href="RicercaCategoriaControl?tipo=telecomandi">Telecomandi<i class="fas fa-chevron-right"></i></a></li>
									<li><a href="RicercaCategoriaControl?tipo=radiocomandi">Radiocomandi<i class="fas fa-chevron-right"></i></a></li>
								</ul>
							</div>

							<!-- Main Nav Menu -->

							<div class="main_nav_menu ml-auto font_size">
								<ul class="standard_dropdown main_nav_dropdown">
								<%
									if(userRoles==null||userRoles.equals("navigatore")){
								%>
									<li><a href="index.jsp">Home<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="contact.jsp">Contatti<i class="fas fa-chevron-down"></i></a></li>
								<%
									}
									else if(userRoles.equals("cliente")){
								%>
									<li><a href="index.jsp">Home<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="contact.jsp">Contatti<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="prenotaRiparazione.jsp">Commissiona una riparazione<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="AttivitaAccountControl?tipoProdotto=prodottoprenotato">Visualizza Prenotazione Prodotti<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="AttivitaAccountControl?tipoProdotto=prodottoinriparazione">Visualizza Prenotazione Riparazione<i class="fas fa-chevron-down"></i></a></li>
								<%
									}
									else if(userRoles.equals("gestoreRiparazioni")){
								%>	
									<li><a href="index.jsp">Home<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="VisualizzaRiparazioniControl">Modifica stato riparazione<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="VisualizzaDateControl">Inserisci le date<i class="fas fa-chevron-down"></i></a></li>
								<%
								}
								else if(userRoles.equals("gestoreProdotti")){
								%>	
									<li><a href="index.jsp">Home<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="inserisciProdottoBoundary.jsp">Inserisci un prodotto<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="VisualizzaProdottiControl">Visualizza Prodotti<i class="fas fa-chevron-down"></i></a></li>
									
								<%
								}
								else if(userRoles.equals("admin")){
								%>
									<li><a href="index.jsp">Home<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="inserisciProdottoBoundary.jsp">Inserisci un prodotto<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="VisualizzaProdottiControl">Visualizza Prodotti<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="VisualizzaRiparazioniControl">Modifica stato riparazione<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="VisualizzaDateControl">Inserisci le date<i class="fas fa-chevron-down"></i></a></li>
									<li><a href="VisualizzaDatiControl">Visualizza dati utente<i class="fas fa-chevron-down"></i></a></li>
								<%
									}
								%>
								</ul>
							</div>

							<!-- Menu Trigger -->

							<div class="menu_trigger_container ml-auto">
								<div class="menu_trigger d-flex flex-row align-items-center justify-content-end">
									<div class="menu_burger">
										<div class="menu_trigger_text">menu</div>
										<div class="cat_burger menu_burger_inner"><span></span><span></span><span></span></div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</nav>
		
		<!-- Menu -->

		<div class="page_menu">
			<div class="container">
				<div class="row">
					<div class="col">
						
						<div class="page_menu_content">
							
							<div class="page_menu_search">
								<form action="Prodotti">
									<input type="search" required="required" class="page_menu_search_input" placeholder="Search for products..." name="search">
								</form>
							</div>
							<%
							if(userRoles==null||userRoles.equals("navigatore")){
							%>
							<ul class="page_menu_nav">
								<li class="page_menu_item">
									<a href="index.jsp">Home<i class="fa fa-angle-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="contact.jsp">Contatti<i class="fa fa-angle-down"></i></a>
								</li>
							</ul>
							<%
							}else
								if(userRoles.equals("cliente")){
							 %>
								<ul class="page_menu_nav">
								<li class="page_menu_item">
									<a href="index.jsp">Home<i class="fa fa-angle-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="contact.jsp">Contatti<i class="fa fa-angle-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="prenotaRiparazione.jsp">Commissiona una riparazione<i class="fa fa-angle-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="AttivitàAccountControl?tipoProdotto=prodottoprenotato"">Visualizza Prenotazione Prodotti<i class="fa fa-angle-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="AttivitàAccountControl?tipoProdotto=prodottoinriparazione"">Visualizza Prenotazione Riparazioni<i class="fa fa-angle-down"></i></a>
								</li>
							</ul>
							<%}else
								if(userRoles.equals("gestoreRiparazioni")){
							%>
								<ul class="page_menu_nav">
								<li class="page_menu_item">
									<a href="index.jsp">Home<i class="fa fa-angle-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="VisualizzaRiparazioniControl">Modifica stato riparazione<i class="fas fa-chevron-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="VisualizzaDateControl">Inserisci le date<i class="fas fa-chevron-down"></i></a>
								</li>
							</ul>
							<%
								}else
									if(userRoles.equals("gestoreProdotti")){
							%>
							<ul class="page_menu_nav">
								<li class="page_menu_item">
									<a href="index.jsp">Home<i class="fa fa-angle-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="inserisciProdottoBoundary.jsp">Inserisci un prodotto<i class="fas fa-chevron-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="VisualizzaProdottiControl">Visualizza Prodotti<i class="fas fa-chevron-down"></i></a>
								</li>
							</ul>
							<%
									}else
										if(userRoles.equals("admin")){
											%>
											<ul class="page_menu_nav">
								<li class="page_menu_item">
									<a href="index.jsp">Home<i class="fa fa-angle-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="inserisciProdottoBoundary.jsp">Inserisci un prodotto<i class="fas fa-chevron-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="VisualizzaRiparazioniControl">Modifica Stato Riparazione<i class="fas fa-chevron-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="VisualizzaDateControl">Inserisci date<i class="fas fa-chevron-down"></i></a>
								</li>
								<li class="page_menu_item">
									<a href="VisualizzaDatiControl">Visualizza Dati Utente<i class="fas fa-chevron-down"></i></a>
								</li>
							</ul>
											<%
											
										}
							%>
							<div class="menu_contact">
								<div class="menu_contact_item"><div class="menu_contact_icon"><img src="images/phone_white.png" alt=""></div>+39 335 837 8319</div>
								<div class="menu_contact_item"><div class="menu_contact_icon"><img src="images/mail_white.png" alt=""></div><a href="#">tutto-elettronica@gmail.com</a></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</header>
	
	<!-- Banner -->

	<div class="banner">
		<div class="banner_background" style="background-image:url(images/banner_background.jpg)"></div>
		<div class="container fill_height">
			<div class="row fill_height">
				<div class="banner_product_image"><img src="images/banner_product.png" alt=""></div>
				<div class="col-lg-5 offset-lg-4 fill_height">
					<div class="banner_content">
						<h1 class="banner_text">new era </h1>
						<div class="banner_price"><span>$150</span>$100</div>
						<div class="banner_product_name">Arduino UNO</div>
						<div class="button banner_button"><a href="Prodotti?search=arduino">Shop</a></div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- FINE HEADER -->

		<div id="mainLogin">
			<div id="subLogin">
				<div id="registrazione">
					<fieldset>
						<legend>Registrazione</legend>
						<h1>Registrati al sito</h1>
						<p>Se non sei registrato, effettua qui la registrazione</p><hr>
						<form name="form1" action="RegistrazioneControl" method="post">
							<input type="hidden" name="ruolo" value="cliente">
							<input type="hidden" name="action" value="registrazione">
							<div class="tableRow2">
							<p>Insert Username: </p><p><input type="text" required name="username"></p>
							</div>
							<div class="tableRow2">
							<p>Insert Password: </p><p><input type="password" required name="password" ></p>
							</div>
							<div class="tableRow2">
							<p>Insert Nome: </p><p><input type="text" required placeholder="Mario" name="nome"></p>
							</div>
							<div class="tableRow2">
							<p>Insert Cognome: </p><p><input type="text" required placeholder="Rossi" name="cognome"></p>
							</div>
							<div class="tableRow2">
							<p>Insert Codice Fiscale: </p><p><input type="text" maxlength="16" required name="cf"></p>
							</div>
							<div class="tableRow2">
							<p>Insert email: </p><p><input type="text" required placeholder="mariorossi@unisa.it" name="email" ></p>
							</div>
							<div class="tableRow2">
							<p>Insert indirizzo: </p><p><input type="text" required placeholder="via roma, Nocera Superiore"name="indirizzo"></p>
							</div>
							<div class="tableRow2">
							<p></p>
							<p><input type="submit" value="Registrati" onclick="return ValidateForm(this.form)"></p>
							</div>
						</form>
					
					  </fieldset>
				</div>
				<div id="login">
					<fieldset>
						<legend>Login</legend>
						<h1>Esegui login</h1>
						<form action="LoginControl" method="post">
						<div class="tableRow2">
							<p>Insert Username: </p><p><input type="text" name="username" required></p>
							</div>
							<div class="tableRow2">
							<p>Insert Password: </p><p><input type="password" name="password" required></p>
							</div>
							<div class="tableRow2">
							<p></p><p><input type="submit" value="Login" onClick="return ValidateLogin(this.form)" ></p>
							</div>
						</form>
					
					</fieldset>
				</div>
			</div>
			
		</div>


<!--  INIZIO FOOTER -->
<!-- Brands -->

	<div class="brands">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="brands_slider_container">
						
						<!-- Brands Slider -->

						<marquee loop= "-1" align="center" direction="left" onmouseover=this.stop() onmouseout=this.start() >
				<img src="images/btcino.png">
				<img src="images/came.png">
				<img src="images/comelit.png">
				<img src="images/gbc.png">
				<img src="images/lamp.png">
				<img src="images/siei.png">
				<img src="images/wentronic.png">
			</marquee>
						
						<!-- Brands Slider Navigation -->
						<div class="brands_nav brands_prev"><i class="fas fa-chevron-left"></i></div>
						<div class="brands_nav brands_next"><i class="fas fa-chevron-right"></i></div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer -->

	<footer class="footer">
		<div class="container">
			<div class="row">

				<div class="col-lg-3 footer_col">
					<div class="footer_column footer_contact">
						<div class="logo_container">
							<div class="logo"><a href="#">Tutto Elettronica</a></div>
						</div>
						<div class="footer_title">Problemi? Contattaci</div>
						<div class="footer_phone">+39 335 837 8319</div>
						<div class="footer_contact_text">
							<p>Via Nazionale 11, Nocera Superiore</p>
						</div>
						<div class="footer_social">
							<ul>
								<li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
								<li><a href="#"><i class="fab fa-twitter"></i></a></li>
								<li><a href="#"><i class="fab fa-youtube"></i></a></li>
								<li><a href="#"><i class="fab fa-google"></i></a></li>
								<li><a href="#"><i class="fab fa-vimeo-v"></i></a></li>
							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>
	</footer>

	<!-- Copyright -->

	<div class="copyright">
		<div class="container">
			<div class="row">
				<div class="col">
					
					<div class="copyright_container d-flex flex-sm-row flex-column align-items-center justify-content-start">
						<div class="copyright_content"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/greensock/TweenMax.min.js"></script>
<script src="plugins/greensock/TimelineMax.min.js"></script>
<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="plugins/greensock/animation.gsap.min.js"></script>
<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/slick-1.8.0/slick.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="js/custom.js"></script>
</body>

</html>