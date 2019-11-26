<!DOCTYPE html>
<html lang="es">
<head>
	<title>Gracia Rubio</title>
	
	<link href='http://fonts.googleapis.com/css?family=Istok+Web:400,700' rel='stylesheet'>
	<link href='http://fonts.googleapis.com/css?family=Yesteryear' rel='stylesheet'>
	<link rel="stylesheet" href="css/style.css" media="screen">
	<link rel="icon" href="images/home2.png" type="image/x-icon">
	<link rel="shortcut icon" href="images/home2.png" type="image/x-icon" />
	<script src="js/jquery.min.js"></script>
	<script src="js/script.js"></script>
	<script src="js/superfish.js"></script>
	<script src="js/jquery.responsivemenu.js"></script>
	<script src="js/jquery.flexslider-min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.ui.totop.js"></script>
	<script type="text/javascript" src="js/modal.popup.js"></script>
	
	
	<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
        
		//Change these values to style your modal popup
		var align = 'center';									//Valid values; left, right, center
		var top = 50; 											//Use an integer (in pixels)
		var width = 800; 										//Use an integer (in pixels)
		var padding = 10;										//Use an integer (in pixels)
		var backgroundColor = '#FFFFFF'; 						//Use any hex code
		var source = '/about'; 								//Refer to any page on your server, external pages are not valid e.g. http://www.google.co.uk
		var borderColor = '#767D76'; 							//Use any hex code
		var borderWeight = 4; 									//Use an integer (in pixels)
		var borderRadius = 5; 									//Use an integer (in pixels)
		var fadeOutTime = 300; 									//Use any integer, 0 = no fade
		var disableColor = '#666666'; 							//Use any hex code
		var disableOpacity = 40; 								//Valid range 0-100
		var loadingImage = 'images/loading.gif';		//Use relative path from this page
			
		//This method initialises the modal popup
        $(".modal").click(function() {
            modalPopup(align, top, width, padding, disableColor, disableOpacity, backgroundColor, borderColor, borderWeight, borderRadius, fadeOutTime, source, loadingImage);
        });
		
        $(".ejemplos").click(function() {
            modalPopup(align, top, width, padding, disableColor, disableOpacity, backgroundColor, borderColor, borderWeight, borderRadius, fadeOutTime, '/about?op=reforma', loadingImage);
        });
		
		//This method hides the popup when the escape key is pressed
		$(document).keyup(function(e) {
			if (e.keyCode == 27) {
				closePopup(fadeOutTime);
			}
		});
		
    });
	</script>
	
	<style type="text/css" media="screen">
		#large_box {width:800; height:600;}
	</style>
	
	<!--[if lt IE 8]>
		<div style=' clear: both; text-align:center; position: relative;'>
			<a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
				<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
			</a>
		</div>
	<![endif]-->
	<!--[if lt IE 9]>
		<script src="js/html5.js"></script>
		<link rel="stylesheet" href="css/ie.css"> 
	<![endif]-->
</head>
<body id="page1">
	<div class="container_12">
		<div class="block-0">
			<!-- header -->
			<header>
				<div class="wrapper block-1">
					<div>
						<h1><a href="/upload"><img src="images/logoT2.png" /></a></h1>
					</div>
					
				</div>
				
				<div class="menu-border">
					<!-- menu -->
					<nav>
						<ul class="sf-menu">
							<li><a href="/">INICIO</a></li>
							<li><a href="#">PROYECTOS</a>
								<ul>
									<li><a href="/Ruca?galeria=obraNueva">OBRA NUEVA</a></li>
									<li><a href="/Ruca?galeria=reformas">REFORMAS</a></li>
									<li><a href="/Ruca?galeria=decoracion">DECORACI&Oacute;N</a></li>
									<li><a href="/Ruca?galeria=oficinas">OFICINAS</a></li>		
								</ul>
							</li>
							<li ><a href="/contacto.jsp">CONTACTO</a></li>
							<li  class="last-child"></li>						
							
						</ul>
						
						<div class="clear"></div>	
					</nav><!-- end menu -->
				</div>
			</header><!-- end header -->
		</div>
			
		<!-- content -->
		<section id="content">
			<div class="wrapper">
					<div id="content">
						<div class="grid_11">
							<p><h5><b>QUE HACEMOS</b></h5></p>
							<br>
						
							<div class="ident-bot-14">
								<img class="fleft image-border-1 ident-right-2" src="images/obraNueva.jpg" alt="Obra nueva" style="display: block; width: 252px; height: 205px;  border: 1px solid white"/>
								<div class="extra-wrap inner-ident-top-1">
									<p><strong><b>OBRA NUEVA</b></strong></p>
									<p>Asesor&iacute;a en interiorismo en cualquiera de las fases en la que se encuentre la obra. Desde
el inicio del Proyecto de Arquitectura, colaborando con el arquitecto y participando en
la planta de distribuci&oacute;n de la vivienda as&iacute; como en la memoria de calidades y haciendo el seguimiento durante toda la obra, hasta su finalizaci&oacute;n y posterior decoraci&oacute;n.<br>
									La memoria de calidades incluye:<br>
									- Suelos y revestimientos, saneamiento y grifer&iacute;as, pintura.<br>
									- Iluminaci&oacute;n: Interruptores, focos y apliques.<br>
									- Puertas, manivelas y pomos y distribuci&oacute;n de armarios y mobiliario a medida.<br>
									- Mobiliario de cocina.</p>
								</div>
								<div class="clear"></div>
							</div>
							<div class="ident-bot-14">
								<img class="fleft image-border-1 ident-right-2" src="images/colores.jpg" alt="Proyectos de reforma interior" style="display: block; width: 252px; height: 205px;  border: 1px solid white"/>
								<div class="extra-wrap inner-ident-top-1">
									<p><strong><b>REFORMA DE INTERIORES</b></strong></p>
									<p align="left">Asesor&iacute;a en la nueva distribuci&oacute;n de la vivienda en base a los requisitos de reforma
planteados por el cliente. La reforma puede ser integral o de alguno de los espacios.
Para ello, se realizar&aacute; el Levantamiento de Planos necesario y se definir&aacute; la memoria
de calidades teniendo en cuenta los materiales empleados en el resto de la vivienda y
que no van a ser sustituidos. Adem&aacute;s del proyecto de reforma de interiores se puede
contratar la coordinaci&oacute;n y/o el seguimiento de la reforma que puede incluir:<br><br></p>
								<table width="550px">
								<tr>
									<td align="left"><a class="modal" href="javascript:void(0);"><strong><b> + VER MAS</b></strong></a></td>
									<td align="right"><a class="ejemplos" href="javascript:void(0);"><strong><b>+ VER EJEMPLOS</b></strong></a></td>
								</tr>
								</table>
									
								</div>
								<div class="clear"></div>
							</div>
							<div class="ident-bot-14">
								<img class="fleft image-border-1 ident-right-2" src="images/telas.jpg" alt="Telas" style="display: block; width: 252px; height: 205px;  border: 1px solid white"/>
								<div class="extra-wrap inner-ident-top-1">
									<p><strong><b>DECORACI&Oacute;N DE VIVIENDAS</b></strong></p>
									<p>Asesor&iacute;a en todo lo concerniente al diseño de interiores:<br>
									- Pintura, empapelados, alfombras y moquetas.<br>
									- Compra de mobiliario, tanto de interior como de exterior, l&aacute;mparas, objetos
decorativos, arte y antigüedades.<br>
									- Diseño y confecci&oacute;n de mobiliario y librer&iacute;as a medida, retapizado de muebles antiguos.<br>
									- Confecci&oacute;n textil: cortinas, colchas, fundas...<br>
									- Instalaci&oacute;n de screen o venecianas.<br>
									- Instalaci&oacute;n de cuadros, espejos, mamparas.<br>
								</div>
								<div class="clear"></div>
							</div>
					</div>
				</div>
			</div>
			
			
		</section><!-- end content -->
	</div>
	<!-- footer -->
	<div class="container_12">
		<hr>
			<div class="wrapper">
				<div class="grid_6">
				<p>C/ Salv&aacute; 8, 5&ordm;-9 - Valencia  963 253 539 / 609 855 196</p>
				</div>
				<div class="grid_6">
				<a href="/upload"><p align="right" style='color: #6f6f71; font:11px/21px "Trebuchet MS", Helvetica, sans-serif;'>&copy; RUCA INTERIORES S.L.</p></a>
				</div>
			</div>
	</div>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-7078796-5']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>	
</body>

<!-- Mirrored from static.livedemo00.template-help.com/wt_38557/index.html by HTTrack Website Copier/3.x [XR&CO'2010], Mon, 09 Apr 2012 19:51:29 GMT -->
</html>
