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
                        <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list"
                           href="/home" role="tab" aria-controls="home">Home</a>
                        <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list"
                           href="account-info" role="tab" aria-controls="profile">Mój profil</a>
                        <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list"
                           href="/search" role="tab" aria-controls="messages">Wyszukiwarka przedmiotów</a>
                        <a class="list-group-item list-group-item-action" id="list-settings-list" data-toggle="list"
                           href="#list-settings" role="tab" aria-controls="settings">Oceń pzedmiot</a>
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
                    <div class="card text-white bg-success mb-3" style="max-width: 18rem;">
                        <div class="card-header">Header</div>
                        <div class="card-body">
                            <h5 class="card-title">Success card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        </div>
                    </div>
                    <div class="card text-white bg-danger mb-3" style="max-width: 18rem;">
                        <div class="card-header">Header</div>
                        <div class="card-body">
                            <h5 class="card-title">Danger card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        </div>
                    </div>
                    <div class="card text-white bg-warning mb-3" style="max-width: 18rem;">
                        <div class="card-header">Header</div>
                        <div class="card-body">
                            <h5 class="card-title">Warning card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        </div>
                    </div>
                    <div class="card text-white bg-info mb-3" style="max-width: 18rem;">
                        <div class="card-header">Header</div>
                        <div class="card-body">
                            <h5 class="card-title">Info card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        </div>
                    </div>
                    <div class="card bg-light mb-3" style="max-width: 18rem;">
                        <div class="card-header">Header</div>
                        <div class="card-body">
                            <h5 class="card-title">Light card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        </div>
                    </div>
                    <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                        <div class="card-header">Header</div>
                        <div class="card-body">
                            <h5 class="card-title">Dark card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        </div>
                    </div>

                </div>
            </div>

    </#if>
</#macro>
<@home/>