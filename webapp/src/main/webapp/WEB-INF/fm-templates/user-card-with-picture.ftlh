<div class="card" style="width: 18rem;">
    <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="card-img-top"
         alt="Daniel Adams">
    <div class="card-body">
        <h5 class="card-title">${user.nickName}</h5>
        <span class="author-card-info">dołączył do E-learning app </span>
        <span class="author-card-info"> ${user.dateOfRegistration}</span><br><br>

        <#if user.aboutMe ??>
            <h5 class="author-card-details">o mnie</h5>
        <p class="card-text">${user.aboutMe}</p>
        </#if>
    </div>
</div>