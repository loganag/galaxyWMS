$(document).ready(function () {
    $("#date").datepicker({
        format: 'yyyy-mm-dd'
    });
});
$(document).on("click", ".delete", function () {
    $(this).parents("tr").remove();
    $(".add-new").removeAttr("disabled");
});
