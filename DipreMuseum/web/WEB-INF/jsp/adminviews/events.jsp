<jsp:include page="../head.jsp"/>

<body>
    <br/>
    <div id="wrapper">
        <jsp:include page="menu.jsp"/>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div id='calendar' ></div>
                    <script>
                        $(document).ready(function () {

                            $('#calendar').fullCalendar({
                                header: {
                                    left: 'prev,next today',
                                    center: 'title',
                                    right: 'month,agendaWeek,agendaDay'
                                },
                                defaultDate: getToday(),
                                editable: true,
                                eventLimit: true, // allow "more" link when too many events
                                events: [
                                    {
                                        title: 'All Day Event',
                                        start: '2016-04-01'
                                    },
                                    {
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
                                    }
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
    <!-- /#wrapper -->

    <jsp:include page="../footer.jsp"/>