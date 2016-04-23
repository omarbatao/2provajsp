

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"/>

<jsp:include page="menu.jsp"/>

<!-- Header Carousel -->
<header id="myCarousel" class="carousel slide">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
        <div class="item active">
            <div class="fill" style="background-image:url('./resources/img/cover1.jpg');"></div>
            <div class="carousel-caption">
                <h2>Le scelte del critico d'arte Andrea Dipr&egrave</h2>
            </div>
        </div>
        <div class="item">
            <div class="fill" style="background-image:url('./resources/img/cover2.jpg');"></div>
            <div class="carousel-caption">
                <h2>Nasce all'interno di New York City</h2>
            </div>
        </div>
        <div class="item">
            <div class="fill" style="background-image:url('./resources/img/cover3.jpg');"></div>
            <div class="carousel-caption">
                <h2>Il museo di riferimento per l'arte contemporanea</h2>
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="icon-prev"></span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="icon-next"></span>
    </a>
</header>

<!-- Page Content -->
<div class="container">

    <!-- Marketing Icons Section -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">
                Benvenuto nel Dipr&egrave Museum
            </h1>
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4><i class="fa fa-university"></i> La massima espressione artistica</h4>
                </div>
                <div class="panel-body">
                    <p>Solo all'interno del Dipr&egrave Museum potrai trovare i migliori quadri, selezionati dal critico d'arte ed avvocato Andrea Dipr&egrave, provenienti da qualunque parte del globo. Il museo garantisce inoltre ampi spazi per la consultazione...</p>
                    <a href="#" class="btn btn-default">Leggi di pi&ugrave</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4><i class="fa fa-calendar"></i> I migliori eventi</h4>
                </div>
                <div class="panel-body">
                    <p>All'interno del Dipr&egrave Museum potrete assistere ai migliori eventi ed alle migliori esposizioni mondiali per quanto concerne l'arte contemporanea. Gli eventi vengono gestiti e supervisionati da uno staff internazionale, prenota subito...</p>
                    <a href="#" class="btn btn-default">Leggi di pi&ugrave</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4><i class="fa fa-cogs"></i> Potenzialit&agrave enormi</h4>
                </div>
                <div class="panel-body">
                    <p>Le semplici visite guidate non sono conformi agli standard del Dipr&egrave Museum, difatti con noi sarai coadiuvato nella visita da strumenti che ti aiuteranno a comprendere meglio quello che stai osservando, quali un audioguida, un catalogo...</p>
                    <a href="#" class="btn btn-default">Leggi di pi&ugrave</a>
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->
    <!-- Features Section -->
    <div class="row">
        <div class="col-md-6">
            <h2 class="page-header">Evento della settimana</h2>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <a href="./evento?id=${evento.getIdVisita()}"> <h4><i class="fa fa-university"></i>${evento.getTitolo()}</h4></a>                        </div>
                <div class="panel-body">
                    <p>Solo all'interno del Dipr&egrave Museum potrai trovare i migliori quadri, selezionati dal critico d'arte ed avvocato Andrea Dipr&egrave, provenienti da qualunque parte del globo. Il museo garantisce inoltre ampi spazi per la consultazione...</p>
                    <a href="./evento?id=${evento.getIdVisita()}" class="btn btn-default">Leggi di pi&ugrave</a>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <img class="img-responsive" src="http://placehold.it/700x450" alt="">
        </div>
    </div>
    <!-- /.row -->

    <!-- Portfolio Section -->
    <div class="row">
        <div class="col-lg-12">
            <h2 class="page-header">Eventi pi&ugrave recenti</h2>
            <c:forEach items="${ultimiEventi}" var="evento">
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <a href="./evento?id=${evento.getIdVisita()}"> <h4><i class="fa fa-university"></i>${evento.getTitolo()}</h4></a>
                        </div>
                        <div class="panel-body">
                            <p>Solo all'interno del Dipr&egrave Museum potrai trovare i migliori quadri, selezionati dal critico d'arte ed avvocato Andrea Dipr&egrave, provenienti da qualunque parte del globo. Il museo garantisce inoltre ampi spazi per la consultazione...</p>
                            <a href="./evento?id=${evento.getIdVisita()}" class="btn btn-default">Leggi di pi&ugrave</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <!-- /.row -->


    <hr>

    <!-- Call to Action Section -->
    <div class="well">
        <div class="row">
            <div class="col-md-8">
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.</p>
            </div>
            <div class="col-md-4">
                <a class="btn btn-lg btn-default btn-block" href="#">Call to Action</a>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>
