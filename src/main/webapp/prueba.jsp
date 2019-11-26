<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en"> 
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
	<title>Fancy Zoom by John Nunemaker</title> 
	<link rel="stylesheet" href="../css/common.css" type="text/css" /> 
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
	<script type="text/javascript" src="js/fancyzoom.min.js"></script>
	<script type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			$('div.photo a').fancyZoom({scaleImg: true, closeOnClick: true});
			$('#medium_box_link').fancyZoom({width:400, height:300});
			$('#large_box_link').fancyZoom();
			$('#flash_box_link').fancyZoom();
		});
	</script>
	
	<style type="text/css" media="screen">
		#large_box {width:800; height:600;}
	</style>
</head> 
<body id="page1">
	<div class="container_12">
		<div class="block-0">
			<!-- header -->
			<header>
				<div class="wrapper block-1">
					<div class="fright">
						<h1><a href="/index.jsp"> GRACIA RUBIO</a></h1>
						<div class="slogan">Interiorista</div>
					</div>
				</div>
				
				<div class="menu-border">
					<!-- menu -->
					<nav>
						<ul class="sf-menu">
							<li><a href="/index.jsp">Inicio</a></li>							
							<li><a href="#">Proyectos</a>
								<ul>
									<li><a href="/nueva.jsp">Obra Nueva</a></li>
									<li><a href="#">Reformas</a></li>
									<li><a href="#">Decoraci&oacute;n</a></li>
									<li><a href="#">Oficinas</a></li>
								</ul>
							</li>
							<li><a href="/hacemos.jsp">Qu&eacute; Hacemos</a></li>
							<li ><a href="/contacto.jsp">Contacto</a></li>
							<li  class="last-child"></li>							
							
						</ul>
						
						<div class="clear"></div>	
					</nav><!-- end menu -->
				</div>
			</header><!-- end header -->
		</div>

			<h3>Images</h3>
			
			<div class="photo">
				<a href="#hotdog">
					<img src="http://farm4.static.flickr.com/3150/2726282580_05ed83e3c0_s.jpg" alt="Github helmet" />
				</a>
			</div>
			<div class="photo">
				<a href="#turtles">
					<img src="http://farm4.static.flickr.com/3088/2709825025_fb6d71b455_s.jpg" alt="Github helmet" />
				</a>
			</div>

			<div id="github">
				<img src="http://farm4.static.flickr.com/3250/2765022017_356efe6a25.jpg" alt="helmet" />
			</div>
			<div id="hotdog">
				<img src="http://farm4.static.flickr.com/3150/2726282580_05ed83e3c0.jpg" alt="Hot dog" />
			</div>
			<div id="turtles">
				<img src="http://farm4.static.flickr.com/3088/2709825025_fb6d71b455.jpg" alt="Turtles" />
				<p id="turtles_caption">It's true, they do bite!</p>
			</div>
	</div>
		
</body> 
</html>