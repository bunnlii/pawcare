document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll('.dismiss-review').forEach(button => {
        button.addEventListener('click', () => {
            const reviewId = button.dataset.reviewId;
            console.log('Dismiss button clicked for review:', reviewId);
            fetch(`/admin/reviews/${reviewId}/dismiss`, { method: 'PUT' })
                .then(response => {
                    if (response.ok) {
                        console.log(`Review ${reviewId} dismissed.`);
                        button.disabled = true;
                    }
                })
                .catch(err => console.error('Error dismissing review:', err));
        });
    });

    document.querySelectorAll('.delete-review').forEach(button => {
        button.addEventListener('click', () => {
            const reviewId = button.dataset.reviewId;
            console.log('Delete button clicked for review:', reviewId);
            fetch(`/admin/reviews/${reviewId}/delete`, { method: 'DELETE' })
                .then(response => {
                    if (response.ok) {
                        console.log(`Review ${reviewId} deleted.`);
                        button.disabled = true;
                    }
                })
                .catch(err => console.error('Error deleting review:', err));
        });
    });
});
