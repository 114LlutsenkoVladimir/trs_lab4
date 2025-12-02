document.addEventListener("DOMContentLoaded", function() {
    const body = document.body;
    const openAttr = body.getAttribute("data-open-error");
    const open = (openAttr === 'true'); // или == 'true'

    if (open) {
        const modalEl = document.getElementById("errorModal");
        if (modalEl) {
            const modal = new bootstrap.Modal(modalEl);
            modal.show();
        }
    }
});
