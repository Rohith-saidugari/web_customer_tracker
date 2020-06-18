$(document).ready(function () {
    // Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });

    $('#editEmployeeModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var data = button.data('customer');
        $(event.currentTarget).find('input[name="firstName"]').val(data['firstName']);
        $(event.currentTarget).find('input[name="lastName"]').val(data['lastName']);
        $(event.currentTarget).find('input[name="emailId"]').val(data['emailId']);
        $('#userForm').attr("action", window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/customer/update/" + button.data('id'));
    });
    $('#deleteEmployeeModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        $('#userDeleteForm').attr("action", window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2)) + "/customer/delete/" + button.data('id'));
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });

});