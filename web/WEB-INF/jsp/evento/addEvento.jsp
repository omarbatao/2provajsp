<%-- 
    Document   : home
    Created on : 23-feb-2016, 9.46.48
    Author     : FSEVERI\ceretta2991
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./layout/head.jsp"/>
<jsp:include page="./layout/menu.jsp"/>

<div class="container">
    <div class="col-lg-7 center-block">
        <form>
            <fieldset class="form-group">
                <label for="evento">Titolo evento:</label>
                <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Titolo dell'evento">
            </fieldset>

            <div class="bfh-selectbox bfh-countries" data-country="US" data-flags="true">
                <input type="hidden" value="">
                <a class="bfh-selectbox-toggle" role="button" data-toggle="bfh-selectbox" href="#">
                    <span class="bfh-selectbox-option input-medium" data-option=""></span>
                    <b class="caret"></b>
                </a>
                <div class="bfh-selectbox-options">
                    <input type="text" class="bfh-selectbox-filter">
                    <div role="listbox">
                        <ul role="option">
                        </ul>
                    </div>
                </div>
            </div>


            <fieldset class="form-group">
                <label for="formGroupExampleInput2">Another label</label>
                <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Another input">
            </fieldset>
        </form>

    </div>
</div>




<jsp:include page="./layout/foot.jsp"/>
