<main>
    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->

            <form method="post" action="/teacher">
                <div class="form-group">
                    <label>zaloguj jako</label>
                </div>
                <div class="form-group col-md-12">
                    <select class="form-control form-control-lg"  name="user">
                        <option value="teacher">nauczyciel</option>
                        <option value="student">student</option>
                    </select>
                </div>
                <input type="text" id="login" class="fadeIn second" name="nickName" placeholder="nickname">
                <input type="text" id="password" class="fadeIn third" name="login" placeholder="password">
                <input type="submit" class="fadeIn bg-jumpers" value="zaloguj">
            </form>
                <div id="formFooter">
                <a class="underlineHover" href="#">zapomniales hasla?</a>
            </div>

        </div>
    </div>
    </form>
</main>