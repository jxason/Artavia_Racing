<%-- 
    Document   : index
    Created on : 8 jul 2024, 17:33:24
    Author     : Andrés Alvarado Matamoeos
    AR-001  Esta vista se usa para pintar el home del sitio una vez registrado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="css/Commons.css" rel="stylesheet" type="text/css"/>
    <link href="css/BaseMenuStyle.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
     <style>
        .carousel-item img {
            height: 500px;
            object-fit: cover;
            width: 100%;
        }
        .section-title {
            margin-top: 20px;
            margin-bottom: 20px;
            text-align: center;
        }
        .card-deck .card {
            margin-bottom: 20px;
        }
        .contact-section {
            margin-top: 40px;
            padding: 20px;
            background-color: #f8f9fa;
        }
        .footer {
            background-color: #343a40;
            color: #ffffff;
            padding: 20px;
            text-align: center;
            position: relative;
            bottom: 0;
            width: 100%;
        }
        
        /* Asegura que el menú esté por encima del carrusel */
        #menu-container {
            position: relative;
            z-index: 1000; /* Asegura que esté por encima del carrusel */
        }

        /* Asegura que el carrusel no interfiera con el menú */
        
        
        .dropdown-menu {
            z-index: 1001; /* Asegura que los submenús se muestren por encima del carrusel */
        }
    </style>
    <script src="js/Menu.js" type="text/javascript"></script>
</head>
<body>
    <div id="menu-container">
        <!-- Menú se cargará aquí -->
    </div>
    
       <!-- Carrusel de Imágenes -->
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>            
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="img/carousel-bg-1.jpg" class="d-block w-100" alt="Imagen 1">
            </div>
            <div class="carousel-item">
                <img src="img/carousel-bg-2.jpg" class="d-block w-100" alt="Imagen 2">
            </div>
            <div class="carousel-item">
                <img src="img/carousel-1.png" class="d-block w-100" alt="Imagen 3">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Anterior</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Siguiente</span>
        </a>
    </div>

    <!-- Sección de Misión, Visión y Trayectoria -->
    <div class="container">
        <div class="section-title">
            <h2>Conócenos</h2>
        </div>
        <div class="card-deck">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Misión</h5>
                    <p class="card-text">Nuestra misión es proporcionar productos de alta calidad que satisfagan las necesidades de nuestros clientes y contribuyan al éxito de sus proyectos.</p>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Visión</h5>
                    <p class="card-text">Queremos ser líderes en la industria, reconocidos por nuestra innovación, calidad y compromiso con el cliente.</p>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Trayectoria</h5>
                    <p class="card-text">Con más de 20 años en el mercado, hemos construido una sólida reputación basada en la excelencia y la confianza de nuestros clientes.</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Sección de Contacto -->
    <div class="contact-section">
        <div class="container">
            <div class="section-title">
                <h2>Contacto</h2>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <h4>Dirección</h4>
                    <p>Calle Ficticia 123, Ciudad, País</p>
                </div>
                <div class="col-md-6">
                    <h4>Teléfono</h4>
                    <p>+123 456 7890</p>
                    <h4>Email</h4>
                    <p>contacto@ejemplo.com</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Pie de Página -->
    <div class="footer">
        <p>&copy; 2024 Tu Empresa. Todos los derechos reservados.</p>
        <p>Síguenos en:
            <a href="#" class="text-light ml-2"><i class="fab fa-facebook-f"></i></a>
            <a href="#" class="text-light ml-2"><i class="fab fa-twitter"></i></a>
            <a href="#" class="text-light ml-2"><i class="fab fa-linkedin-in"></i></a>
        </p>
    </div>

    <!-- Bootstrap JS, Popper.js, jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
