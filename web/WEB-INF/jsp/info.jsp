<%-- 
    Document   : infoù
    Created on : 21-mag-2016, 11.57.43
    Author     : FSEVERI\reginato2906
--%>

   <!-- Navigation -->
        <jsp:include page="./layout/include.jsp"/>

            <jsp:include page="./layout/head.jsp"/>
    
    <jsp:include page="./layout/menu.jsp"/>

    <!-- Page Content -->
    <div class="container">
         
        <div class="row">
                <div class="col-lg-12">
                    <h2 class="page-header">Informazioni</h2>
                </div>
                <div class="col-md-4">
                    <h3>Contatti  </h3>
                    <p> <font size="3"><b>Telefono:</b></font> (035) 456-7890</p>
                    <p> <font size="3"><b>Email:</b></font> info@gmail.com </p>
                </div>
        </div>
        <div class="row">
            <div class="col-md-8">
                <h3>Inviaci un messaggio</h3>
                <form name="sentMessage" id="contactForm" action="./email" novalidate>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Nome:</label>
                            <input type="text" class="form-control" id="nome" name='nome' required data-validation-required-message="Please enter your name.">
                            <p class="help-block"></p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Indirizzo e-mail:</label>
                            <input type="email" class="form-control" id="email" name='email' required data-validation-required-message="Please enter your email address.">
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>Messaggio:</label>
                            <textarea rows="10" cols="100" class="form-control" id="messaggio" name='messaggio' required data-validation-required-message="Please enter your message" maxlength="500" style="resize:none"></textarea>
                        </div>
                    </div>
                    <div id="success"></div>
                    <!-- For success/fail messages -->
                    <button type="submit" action="./email" class="btn btn-primary">Invia messaggio</button>
                </form>
            </div>

        </div>
          
    <jsp:include page="./layout/foot.jsp"/>
