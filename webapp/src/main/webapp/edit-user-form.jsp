<main>
    <header>
        <h1>Edit an user</h1>
        <p>Use bellow form.</p>
    </header>
    <form method="post" action="/user" class="contact-from">
        <div class="form">
            <label for="nickname">Nickname:</label>
            <input type="text" name="name" id="nickname" required/>
        </div>
        <div class="form">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required/>
        </div>
        <div class="form">
            <label for="services">User type:</label>
            <select id="services">
                <option value="teacher">Teacher</option>
                <option value="student">Student</option>
            </select>
        </div>
        <div class="form">
            <label for="description">Massage:</label>
            <textarea name="description"></textarea>
        </div>
        <div class="form">
            <button type="submit  " class="btn btn-dark">Send</button>
        </div>
    </form>

</main>