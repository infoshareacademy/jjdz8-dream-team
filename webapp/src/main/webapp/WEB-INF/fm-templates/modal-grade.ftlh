<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Oceń nauczyciela</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="/teacher/grades">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox1" name="grade" value="1">
                    <label class="form-check-label" for="inlineCheckbox1">1</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox2" name="grade" value="2">
                    <label class="form-check-label" for="inlineCheckbox2">2</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox3" name="grade" value="3" >
                    <label class="form-check-label" for="inlineCheckbox3">3</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox4" name="grade" value="4">
                    <label class="form-check-label" for="inlineCheckbox4">4</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox5" name="grade" value="5">
                    <label class="form-check-label" for="inlineCheckbox5">5</label>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Wprowadź swój komentarz</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="comment"></textarea>
                </div>
                    <input type="submit" class="btn btn-primary">Oceń</input>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Zrezygnuj</button>

            </div>

        </div>
    </div>
</div>