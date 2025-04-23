document.addEventListener("DOMContentLoaded", function () {
    const tableBody = document.querySelector("#userTableBody");

    function fetchAndDisplayUsers() {
        fetch('/admin/users')
            .then(res => res.json())
            .then(users => {
                tableBody.innerHTML = '';
                users.forEach(user => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.role}</td>
                        <td>${user.status}</td>
                        <td>
                            <button class="btn ${user.status === 'BANNED' ? 'btn-success' : 'btn-danger'} btn-sm toggle-ban" data-user-id="${user.id}">
                                ${user.status === 'BANNED' ? 'Unban' : 'Ban'}
                            </button>
                        </td>
                    `;
                    tableBody.appendChild(row);
                });

                document.querySelectorAll('.toggle-ban').forEach(btn => {
                    btn.addEventListener('click', () => {
                        const userId = btn.getAttribute('data-user-id');
                        fetch(`/admin/users/${userId}/toggle-ban`, { method: 'PUT' })
                            .then(res => {
                                if (res.ok) {
                                    fetchAndDisplayUsers();
                                } else {
                                    console.error('Error updating user status');
                                }
                            })
                            .catch(err => console.error('Error:', err));
                    });
                });
            })
            .catch(err => console.error('Error fetching users:', err));
    }

    fetchAndDisplayUsers();
});
