document.addEventListener("DOMContentLoaded", function () {

    document.querySelectorAll('.flag-review').forEach(button => {
        button.addEventListener('click', () => {
            const reviewId = button.dataset.reviewId;

            fetch(`/admin/reviews/${reviewId}/flag`, { method: 'PUT' })
                .then(response => {
                    if (response.ok) {
                        console.log(`Review ${reviewId} flagged.`);
                        button.innerText = "Flagged";
                        button.classList.remove('btn-warning');
                        button.classList.add('btn-secondary');
                        button.disabled = true;
                    }
                })
                .catch(err => console.error('Error flagging review:', err));
        });
    });
});
