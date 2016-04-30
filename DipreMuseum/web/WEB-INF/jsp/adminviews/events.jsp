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
                                <form class="form-horizontal">
                                    <div class="form-group">
                                        <label for="idevento" class="col-sm-2 control-label">Id Event</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="idevento" placeholder="id">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="title" class="col-sm-2 control-label">Title </label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="title" placeholder="Event Title">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="price" class="col-sm-2 control-label">Price </label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="price" placeholder="Event price">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="dataI" class="col-sm-2 control-label">Start date </label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="titolo" placeholder="Event start date">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="dataF" class="col-sm-2 control-label">End date </label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="titolo" placeholder="Event end date">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="maxp" class="col-sm-2 control-label">Max people </label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="maxp" placeholder="Max people">
                                        </div>
                                    </div>
                                        <input type="hidden" id="idA" value="12"/>
                                    <!--<div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> Remember me
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    Visite (IdV, Titolo, Tariffa, DataI, DataF, MaxPartecipanti, IdA)
                                    -->
                                    <div class="form-group">
                                         <div class="col-sm-offset-2 col-sm-10">
                                            <button data-dismiss="modal" class="btn btn-danger">Cancel</button>
                                            <button type="submit" class="btn btn-success">Add</button>
                                        </div>
                                    </div>
                                    
                                    
                                </form>
                            </div>
                            
                            <!--<div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save Event</button>
                            </div>-->
                        </div>
                    </div>
                </div>
                
                
                
                
                
                
                
                
                
                
                


                <div class="row">
                    <div class="col-md-12">
                        <div id='calendar' ></div>
                        <script>
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

                            <%
                                List<Visita> eventi = (List) request.getAttribute("eventi");
                                String s = "";
                                for (Visita evento : eventi) {
                                    s += "{ id: '" + evento.getIdVisita() + "', title: '" + evento.getTitolo() + "', start: '" + evento.getDateIString() + "', end: '" + evento.getDateFString() + "' }, ";

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
                                    ]
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

                        </script>
                    </div>
                </div>
            </div>


        </div>
    </div>
    <!-- /#wrapper -->

    <jsp:include page="../footer.jsp"/>