document.getElementById('toggleOrderTable').addEventListener('click', function () {
    var orderTable = document.getElementById('orderTable');
    if (orderTable.classList.contains('hidden')) {
        orderTable.classList.remove('hidden');
    } else {
        orderTable.classList.add('hidden');
    }
});
