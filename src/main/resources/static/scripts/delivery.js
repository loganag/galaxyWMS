$(document).ready(function () {
    $('#dtBasicExample').DataTable({
        "paging": true
    });
    $('.dataTables_length').addClass('bs-select');
});

$( document ).ready(function() {
    $("#date").datepicker({
        format: 'yyyy-mm-dd'
    });
});