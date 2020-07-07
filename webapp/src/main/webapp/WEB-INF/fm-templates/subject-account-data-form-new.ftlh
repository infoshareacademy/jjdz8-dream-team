<#include "base-login-user.ftlh">
<#macro content>
    <div class="card">
        <div class="card-header">
            Dane przedmiotu
        </div>
        <br>
            <div class="form col-md-12">
                <form method="post" action="http://localhost:8080/subject">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="name">kategoria przedmiotu</label><br>
                            <input id="name" type="text" name="name" ><br/><br/>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="topic">temat</label><br>
                            <input id="topic" type="text" name="topic" ><br/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <p>video materials</p>
                            <select id="isVideo" name="isVideo">
                                <option value="true">tak</option>
                                <option value="false">nie</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="videoLink">link do wideo materiałów</label><br>
                            <input id="videoLink" type="text" name="videoLink"
                                   ><br/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="description">Opis przedmiotu</label><br>
                            <textarea id="description" type="text"
                                      name="description"></textarea><br/>
                        </div>
                    </div>
                    <input type="hidden" name="id" value="${user.id}"/><br/>
                    <div class="form-group col-md-6">
                        <input class="btn btn-primary" type="submit" name="save" value="save"/><br/>
                    </div>
                </form>
            </div>
    </div>
</#macro>
<@home/>