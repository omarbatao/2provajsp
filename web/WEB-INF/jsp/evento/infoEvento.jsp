<%@page import="Models.Commento"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/head.jsp"/>
<jsp:include page="../layout/menu.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1>${evento.getTitolo()} <small>${evento.getData()} ${evento.getLuogo().getNomeProvincia()}</small></h1>
                <h4>Creato da ${evento.getIdU().getNickname()}</h4>
            </div>
        </div>
    </div>



    <!-- Comments Form -->
    <div class="well">
        <h4>Leave a Comment:</h4>
        <form role="form" method='post' action="./addComment">
            <div class="form-group">
                <textarea id='testo' name='testo' class="form-control" rows="3"></textarea>
            </div>
            <div class="form-group">
                <label for="voto">Lascia il tuo voto</label>
                <div id="stars-default"><input type="hidden" name="voto"/> </div>
            </div>
            <input type="hidden" name='eventoid' value="${evento.getId()}"/>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>



    <script>
        //the $(document).ready() function is down at the bottom

        (function ($) {

            $.fn.rating = function (method, options) {
                method = method || 'create';
                // This is the easiest way to have default options.
                var settings = $.extend({
                    // These are the defaults.
                    limit: 5,
                    value: 1,
                    glyph: "glyphicon-star",
                    coloroff: "gray",
                    coloron: "gold",
                    size: "2.0em",
                    cursor: "default",
                    onClick: function () {
                    },
                    endofarray: "idontmatter"
                }, options);
                var style = "";
                style = style + "font-size:" + settings.size + "; ";
                style = style + "color:" + settings.coloroff + "; ";
                style = style + "cursor:" + settings.cursor + "; ";



                if (method == 'create')
                {
                    //this.html('');	//junk whatever was there

                    //initialize the data-rating property
                    this.each(function () {
                        attr = $(this).attr('data-rating');
                        if (attr === undefined || attr === false) {
                            $(this).attr('data-rating', settings.value);
                        }
                    })

                    //bolt in the glyphs
                    for (var i = 0; i < settings.limit; i++)
                    {
                        this.append('<span data-value="' + (i + 1) + '" class="ratingicon glyphicon ' + settings.glyph + '" style="' + style + '" aria-hidden="true"></span>');
                    }

                    //paint
                    this.each(function () {
                        paint($(this));
                    });

                }
                if (method == 'set')
                {
                    this.attr('data-rating', options);
                    this.each(function () {
                        paint($(this));
                    });
                }
                if (method == 'get')
                {
                    return this.attr('data-rating');
                }
                //register the click events
                this.find("span.ratingicon").click(function () {
                    rating = $(this).attr('data-value')
                    $(this).parent().attr('data-rating', rating);
                    paint($(this).parent());
                    settings.onClick.call($(this).parent());
                })
                function paint(div)
                {
                    rating = parseInt(div.attr('data-rating'));
                    div.find("input").val(rating);	//if there is an input in the div lets set it's value
                    div.find("span.ratingicon").each(function () {	//now paint the stars

                        var rating = parseInt($(this).parent().attr('data-rating'));
                        var value = parseInt($(this).attr('data-value'));
                        if (value > rating) {
                            $(this).css('color', settings.coloroff);
                        }
                        else {
                            $(this).css('color', settings.coloron);
                        }
                    })
                }

            };

        }(jQuery));

        $(document).ready(function () {
            $("#stars-default").rating();
        });

    </script>



    <hr>

    <!-- Posted Comments -->
    <%!
        public String printrow(int voto) {
            String s = "";
            for (int i = 0; i < 5; i++) {
                if (i < voto) {
                    s += "<span class='glyphicon glyphicon-star' aria-hidden='true'></span>";
                } else {
                    s += "<span class='glyphicon glyphicon-star-empty' aria-hidden='true'></span>";
                }

            }

            return s;
        }
    %>

    <%
        if (request.getParameter("errore") != null) {
            if (request.getParameter("errore").equals("nocommenti")) {
    %>
    <div class='row'>
        <div class="col-md-12">
            <div class="alert alert-info" role="alert">Nessun commento per questo evento</div>
        </div>
    </div>
    <%
        } else if(request.getParameter("errore").equals("false")){

    %>

    <div class="row">
        <div class="media">
            <c:forEach items="${commenti}" var="commento"> 
                <div class="col-md-12">
                    <div class="media-body">
                        <c:if test="${commento.getVoto()<3 }">
                            <div class="panel panel-danger">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div id="user" class="col-md-10">
                                            ${commento.getIdU().getNickname()}
                                        </div>
                                        <div id="voto" class="col-md-2">
                                            Voto: 
                                            <%  
                                                Commento c = (Commento) pageContext.getAttribute("commento");
                                                out.print(printrow(c.getVoto()));
                                            %>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body"> ${commento.getCommento()}</div>
                            </div>
                        </c:if>
                        <c:if test="${commento.getVoto() ==3 }">
                            <div class="panel panel-warning">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div id="user" class="col-md-10">
                                            ${commento.getIdU().getNickname()}
                                        </div>
                                        <div id="voto" class="col-md-2">
                                            Voto: 
                                            <%
                                                Commento a = (Commento) pageContext.getAttribute("commento");
                                                out.print(printrow(a.getVoto()));
                                            %>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body"> ${commento.getCommento()}</div>
                            </div>
                        </c:if>
                        <c:if test="${commento.getVoto() >3 }">
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div id="user" class="col-md-10">
                                            ${commento.getIdU().getNickname()}
                                        </div>
                                        <div id="voto" class="col-md-2">
                                            Voto:
                                            <%
                                                Commento b = (Commento) pageContext.getAttribute("commento");
                                                out.print(printrow(b.getVoto()));
                                            %>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body"> ${commento.getCommento()}</div>
                            </div>
                        </c:if>  
                    </div>
                </div>
            </c:forEach>
        </div>
    </div> 
    <%
            }else{
            %>
            <div class='row'>
        <div class="col-md-12">
            <div class="alert alert-info" role="alert">Nessun commento per questo evento</div>
        </div>
    </div>
    <%
        }
        }
    %>

    <!-- Comment -->


</div>



<jsp:include page="../layout/foot.jsp"/>