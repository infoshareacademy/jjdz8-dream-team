<#include "base-login-user.ftlh">
<#macro content>
    <#if incorrectForm ??>
        <div class="alert alert-danger" role="alert">
            Coś poszło nie tak. Spróbuj jeszcze raz
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    <#if subject ??>
            <div class="row">
                <div class="col-sm">
                    <div class="list-group" id="list-tab" role="tablist">
                        <a href="/home" class="list-group-item list-group-item-action">Home</a>
                        <a href="/account-info" class="list-group-item list-group-item-action">Mój profil</a>
                        <a href="/search" class="list-group-item list-group-item-action">Wyszukiwarka przedmiotów</a>
                    </div>

                </div>
                <div class="col-sm">
                    <p>Materiał dla przedmiot : ${subject.name}</p>
                    <embed src="${subject.material}" width="800px" height="2100px"/>

                </div>
                <div class="col-sm">
                    <div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
                        <div class="card-header">Nauczyciel prowadzący przedmiot</div>
                        <div class="card-body">
                            <h5 class="card-title"><a style="color: #0d0d0d" href="http://localhost:8080/subjects?id=${subject.id}&afterSearch=true">${subject.user.nickName}</a></h5>
                        </div>
                    </div>
                    <div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
                        <div class="card-header">Średnia ocena przedmiotu</div>
                        <div class="card-body">
                            <h5 class="card-title"><a style="color: #0d0d0d" href="#">pokaż szczegóły oceny</a></h5>
                        </div>
                    </div>
                </div>
            </div>

    </#if>
</#macro>
<@home/>