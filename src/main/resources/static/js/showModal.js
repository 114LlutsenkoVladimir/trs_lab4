document.addEventListener('DOMContentLoaded', function () {
    const modal = document.getElementById('productInfoModal');
    if (!modal) return;

    modal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget;
        if (!button) return;

        const url = button.getAttribute('data-bs-url');
        const container = modal.querySelector('#productDetailsContainer');

        if (!url || !container) return;

        // Можно показать прелоадер
        container.innerHTML = '<p>Завантаження...</p>';

        fetch(url)
            .then(response => response.text())
            .then(html => {
                container.innerHTML = html;
            })
            .catch(err => {
                console.error(err);
                container.innerHTML = '<p>Помилка завантаження даних.</p>';
            });
    });
});
