<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.model.MediaObject" %>
<%@ page import="com.model.Gallery" %>
<%@ page import="java.util.List" %>
<%
  User user = (User) request.getAttribute("user");
  String authURL = (String) request.getAttribute("authURL");
  String uploadURL = (String) request.getAttribute("uploadURL");
 
  Gallery gallery = (Gallery) request.getAttribute("galeria");
  
  if(gallery != null)  System.out.println(gallery.getName());
  int contador=0;
%>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Gracia Rubio</title>
	
	<link href='http://fonts.googleapis.com/css?family=Istok+Web:400,700' rel='stylesheet'>
	<link href='http://fonts.googleapis.com/css?family=Yesteryear' rel='stylesheet'>
	<link rel="stylesheet" href="css/style.css" media="screen">
	<link rel="stylesheet" href="css/jquery.fancybox.css?v=2.0.6" media="screen" />	
	<link rel="stylesheet" href="css/jquery.fancybox-buttons.css?v=1.0.2" media="screen" />	
		
	<link rel="icon" href="images/home2.png" type="image/x-icon">
	<link rel="shortcut icon" href="images/home2.png" type="image/x-icon" />
	
	<script src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="js/jquery.mousewheel-3.0.6.pack.js"></script>
	<script src="js/script.js"></script>
	<script src="js/superfish.js"></script>
	<script src="js/jquery.responsivemenu.js"></script>
	<script src="js/jquery.flexslider-min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.ui.totop.js"></script>
	<script src="js/jquery.fancybox.js?v=2.0.6"></script>
	<script src="js/jquery.fancybox-buttons.js?v=1.0.2"></script>
		<script>
		$(document).ready(function() {
			/*
			 *  Simple image gallery. Uses default settings
			 */

			$('.fancybox').fancybox();

			/*
			 *  Different effects
			 */

			// Change title type, overlay opening speed and opacity
			$(".fancybox-effects-a").fancybox({
				helpers: {
					title : {
						type : 'outside'
					},
					overlay : {
						speedIn : 500,
						opacity : 0.95
					}
				}
			});

			// Disable opening and closing animations, change title type
			$(".fancybox-effects-b").fancybox({
				openEffect  : 'none',
				closeEffect	: 'none',

				helpers : {
					title : {
						type : 'over'
					}
				}
			});

			// Set custom style, close if clicked, change title type and overlay color
			$(".fancybox-effects-c").fancybox({
				wrapCSS    : 'fancybox-custom',
				closeClick : true,

				helpers : {
					title : {
						type : 'inside'
					},
					overlay : {
						css : {
							'background-color' : '#eee'
						}
					}
				}
			});

			// Remove padding, set opening and closing animations, close if clicked and disable overlay
			$(".fancybox-effects-d").fancybox({
				padding: 0,

				openEffect : 'elastic',
				openSpeed  : 150,

				closeEffect : 'elastic',
				closeSpeed  : 150,

				closeClick : true,

				helpers : {
					overlay : null
				}
			});

			/*
			 *  Button helper. Disable animations, hide close button, change title type and content
			 */

			$('.fancybox-buttons').fancybox({
				openEffect  : 'none',
				closeEffect : 'none',

				prevEffect : 'none',
				nextEffect : 'none',

				closeBtn  : false,

				helpers : {
					title : {
						type : 'inside'
					},
					buttons	: {}
				},

				afterLoad : function() {
					this.title = 'Image ' + (this.index + 1) + ' of ' + this.group.length + (this.title ? ' - ' + this.title : '');
				}
			});


			/*
			 *  Thumbnail helper. Disable animations, hide close button, arrows and slide to next gallery item if clicked
			 */

			$('.fancybox-thumbs').fancybox({
				prevEffect : 'none',
				nextEffect : 'none',

				closeBtn  : false,
				arrows    : false,
				nextClick : true,

				helpers : {
					thumbs : {
						width  : 50,
						height : 50
					}
				}
			});

			/*
			 *  Media helper. Group items, disable animations, hide arrows, enable media and button helpers.
			*/
			$('.fancybox-media')
				.attr('rel', 'media-gallery')
				.fancybox({
					openEffect : 'none',
					closeEffect : 'none',
					prevEffect : 'none',
					nextEffect : 'none',

					arrows : false,
					helpers : {
						media : {},
						buttons : {}
					}
				});

			/*
			 *  Open manually
			 */

			$("#fancybox-manual-a").click(function() {
				$.fancybox.open('1_b.jpg');
			});

			$("#fancybox-manual-b").click(function() {
				$.fancybox.open({
					href : 'iframe.html',
					type : 'iframe',
					padding : 5
				});
			});

			$("#fancybox-manual-c").click(function() {
				$.fancybox.open([
					{
						href : '1_b.jpg',
						title : 'My title'
					}, {
						href : '2_b.jpg',
						title : '2nd title'
					}, {
						href : '3_b.jpg'
					}
				], {
					helpers : {
						thumbs : {
							width: 75,
							height: 50
						}
					}
				});
			});


		});
		</script>
	
	
	<style type="text/css">
		.fancybox-custom .fancybox-skin {
			box-shadow: 0 0 50px #222;
		}
	</style>
	
	
	
</head>
<body id="page1">
	<div class="container_12">
		<div class="block-0">
			<!-- header -->
			
				<div class="wrapper block-1">
					<div>
						<h1><img src="images/logoT2.png" /></h1>
					</div>
					
				</div>
				
				<div class="menu-border">
					<!-- menu -->
					<nav>
						<ul class="sf-menu">
							<li><a href="/"><center>INICIO</center></a></li>					
							<li class="current"><center><a href="#">PROYECTOS</a></center>
								<ul>
									<li><a href="/Ruca?galeria=obraNueva"><center>OBRA NUEVA</center></a></li>
									<li><a href="/Ruca?galeria=reformas"><center>REFORMAS</center></a></li>
									<li><a href="/Ruca?galeria=decoracion"><center>DECORACI&Oacute;N</center></a></li>
									<li><a href="/Ruca?galeria=oficinas"><center>OFICINAS</center></a></li>	
								</ul>
							</li>
							<li ><a href="/contacto.jsp"><center>CONTACTO</center></a></li>
						</ul>
						
						<div class="clear"></div>	
					</nav><!-- end menu -->
				</div>
			
		</div>
			
		<!-- content -->
			<div class="wrapper">
					<div id="content">
						<div class="grid_12b">
							<p><h5><b>PROYECTOS > OBRA NUEVA</b></h5></p> <BR>
							<!--Circle-->
							
							<%
							if(gallery != null){
								for(MediaObject foto: gallery.getFotos()){
									if(foto.isPrincipal()){
										String descripcion= foto.getDescription();
										 if(descripcion != null){
											   descripcion = descripcion.replaceAll("á", "&aacute;");
											   descripcion = descripcion.replaceAll("é", "&eacute;");
											   descripcion = descripcion.replaceAll("í", "&iacute;");
											   descripcion = descripcion.replaceAll("ó", "&oacute;");
											   descripcion = descripcion.replaceAll("ú", "&uacute;");
											   
										   }
										String urlName="/?galeria=obraNueva&nombre=" + foto.getTitle()+"&desc="+descripcion ;
							%>
							
								<a  href="<%=urlName%>"  title="<%=descripcion%>"><div class="photoDiv">
										<img src="<%=foto.getURLPath() %>"  style="display: block; height: 200px; margin:0px; padding:0px; border: 1px solid white"/>
										<br><center><%=foto.getDescription()%></center>
								</div></a>	
								
							
							<%
									}
								}
							}else{
							%>
								<a  href="vivienda.jsp"  title="Unifamiliar en Bétera"><div class="photoDiv">
										<img src="images/salon.jpg" alt="Bétera" style="display: block; height: 200px; margin:0px; padding:0px; border: 1px solid white"/>
										<br><center>Unifamiliar en Bétera</center>
								</div></a>	
							<%
							}
							%>
							
						</div>
					</div>
			</div>
	</div>
		
	
		
	<!-- footer -->
	<div class="container_12">
		<hr>
			<div class="wrapper">
				<div class="grid_6">
				<p style='font:11px/21px "Trebuchet MS", Helvetica, sans-serif;'>C/ Salv&aacute; 8, 5&ordm;-9 - Valencia  963 253 539 / 609 855 196</p>
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
