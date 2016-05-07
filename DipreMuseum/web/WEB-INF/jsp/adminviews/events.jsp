<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="models.Visita"%>
<jsp:include page="../head.jsp"/>

<body>
    <div id="wrapper">
        <jsp:include page="menu.jsp"/>
        <div id="page-wrapper" >
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Events <small>manage events</small>
                        </h1>
                    </div>
                </div>
            </div>
            <!-- /.row -->
            <div class="container">
                <!-- Button trigger modal -->
                <div class="row">
                    <div class="col-md-12">
                        <%
                            if (request.getParameter("inserito") != null) {
                                if (request.getParameter("inserito").equals("fasle")) {

                        %>
                        <div class="alert alert-danger" role="alert">Event error not set</div>
                        <%            } else {
                        %>
                        <div class="alert alert-success" role="alert">Successfully added event</div>
                        <%
                                }
                            }
                        %>
                    </div>
                </div>

                <div class="row pad">
                    <div class="col-md-12">
                        <form class="form-inline" role="search">
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#addevent" >Add event</button>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Find Event">
                            </div>
                            <button type="submit" class="btn btn-default">Search</button>
                        </form>
                    </div>  
                </div>




                <!-- Modal -->
                <div class="modal fade" id="addevent" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Add event</h4>
                            </div>

                            <div class="modal-body">
                                <form action='./adminaddevent' method="POST">
                                    <div class="form-group">
                                        <label for="idvisita">Event's id</label>
                                        <input name="idvisita" type="text" class="form-control" id="idvisita" placeholder="Event's code">
                                    </div>
                                    <div class="form-group">
                                        <label for="titolo">Title</label>
                                        <input name="titolo" type="text" class="form-control" id="titolo" placeholder="Event's title">
                                    </div>
                                    <div class="form-group">
                                        <label for="desc">Description</label>
                                        <textarea name="desc" type="text" class="form-control" id="desc" placeholder="Event 's description"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="price">Price</label>
                                        <input name="price" type="text" class="form-control" id="price" placeholder="Event 's price">
                                    </div>
                                    <div class="form-group">
                                        <label for="dataI">Start date</label>
                                        <input name="dataI" type="text" class="form-control" id="dataI">
                                    </div>
                                    <div class="form-group">
                                        <label for="dataF">End date</label>
                                        <input name="dataF" type="text" class="form-control" id="dataF">
                                    </div>
                                    <div class="form-group">
                                        <label for="maxp">Max people</label>
                                        <input name="maxp" type="text" class="form-control" id="maxp" placeholder="Event's max people">
                                    </div>
                                    <button type="submit" class="btn btn-warning">Add</button>
                                    <button  type="button" class="btn btn-default"  data-dismiss="modal">Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div id='calendar' ></div>
                        <script>

                            $(function () {
                                $("#dataI").datepicker({
                                    changeMonth: true,
                                    changeYear: true,
                                    showButtonPanel: true,
                                    yearRange: '1910:2016'

                                });
                            });

                            $(function () {
                                $("#dataF").datepicker({
                                    changeMonth: true,
                                    changeYear: true,
                                    showButtonPanel: true,
                                    yearRange: '1910:2016'

                                });
                            });

                            $(document).ready(function () {

                                $('#calendar').fullCalendar({
                                    header: {
                                        left: 'prev,next today',
                                        center: 'title',
                                        right: 'month'
                                    },
                                    defaultDate: getToday(),
                                    editable: true,
                                    eventLimit: true, // allow "more" link when too many events
                                    events: [
                                        /*{
                                         title: 'All Day Event',
                                         start: '2016-04-01'
                                         }*/

                            <%                                List<Visita> eventi = (List) request.getAttribute("eventi");
                                String s = "";
                                for (Visita evento : eventi) {
                                    s += "{ id: '" + evento.getIdVisita() + "', title: '" + evento.getTitolo() + "', start: '" + evento.getDataIString() + "', end: '" + evento.getDataFString() + "' }, ";

                                }
                                s = s.substring(0, s.length() - 2);
                                out.println(s);
                            %>


                                        /*{
                                         title: 'Long Event',
                                         start: '2016-04-07',
                                         end: '2016-04-10'
                                         },
                                         {
                                         id: 999,
                                         title: 'Repeating Event',
                                         start: '2016-04-09T16:00:00'
                                         },
                                         {
                                         id: 999,
                                         title: 'Repeating Event',
                                         start: '2016-04-16T16:00:00'
                                         },
                                         {
                                         title: 'Conference',
                                         start: '2016-04-11',
                                         end: '2016-04-13'
                                         },
                                         {
                                         title: 'Meeting',
                                         start: '2016-04-12T10:30:00',
                                         end: '2016-04-12T12:30:00'
                                         },
                                         {
                                         title: 'Lunch',
                                         start: '2016-04-12T12:00:00'
                                         },
                                         {
                                         title: 'Meeting',
                                         start: '2016-04-12T14:30:00'
                                         },
                                         {
                                         title: 'Happy Hour',
                                         start: '2016-04-12T17:30:00'
                                         },
                                         {
                                         title: 'Dinner',
                                         start: '2016-04-12T20:00:00'
                                         },
                                         {
                                         title: 'Birthday Party',
                                         start: '2016-04-13T07:00:00'
                                         },
                                         {
                                         title: 'Click for Google',
                                         url: 'http://google.com/',
                                         start: '2016-04-28'
                                         }*/
                                    ], eventClick: function (event) {
                                       openmodal("modal"+event.id);
                                    }
                                });

                            });




                            function getToday() {
                                var today = new Date();
                                var dd = today.getDate();
                                var mm = today.getMonth() + 1; //January is 0!
                                var yyyy = today.getFullYear();

                                if (dd < 10) {
                                    dd = '0' + dd
                                }

                                if (mm < 10) {
                                    mm = '0' + mm
                                }

                                return mm + '-' + dd + '-' + yyyy;
                            }

                            function openmodal(id) {
                                $("#" + id).modal()
                            }

                        </script>

                        <c:forEach items="${eventi}" var="evento">
                            <div class="modal fade" id="modal${evento.getIdVisita()}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myModalLabel">Info event</h4>
                                        </div>

                                        <div class="modal-body">
                                            <form action='./adminaddevent' method="POST">
                                                <div class="form-group">
                                                    <label for="idvisita">Event's id</label>
                                                    <input name="idvisita" type="text" class="form-control" id="idvisita" value="${evento.getIdVisita()}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="titolo">Title</label>
                                                    <input name="titolo" type="text" class="form-control" id="titolo" value="${evento.getTitolo()}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="desc">Description</label>
                                                    <textarea name="desc" type="text" class="form-control" id="desc">${evento.getDescrizione()}</textarea>
                                                </div>
                                                <div class="form-group">
                                                    <label for="price">Price</label>
                                                    <input name="price" type="text" class="form-control" id="price" value="${evento.getTariffa()}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="dataI">Start date</label>
                                                    <input name="dataI" type="text" class="form-control" id="dataI" value="${evento.getDataIString()}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="dataF">End date</label>
                                                    <input name="dataF" type="text" class="form-control" id="dataF" value="${evento.getDataFString()}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="maxp">Max people</label>
                                                    <input name="maxp" type="text" class="form-control" id="maxp" value="${evento.getMaxPartecipanti()}">
                                                </div>
                                                <button type="submit" class="btn btn-warning">Modify</button>
                                                <button  type="button" class="btn btn-default"  data-dismiss="modal">Cancel</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>  
                    </div>
                </div>
            </div>


        </div>
    </div>
    <!-- /#wrapper -->


    <jsp:include page="../footer.jsp"/>