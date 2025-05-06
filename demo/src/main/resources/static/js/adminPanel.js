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
                        <td id="status-${user.id}">${user.status}</td> 
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
                        const userId = btn.dataset.userId;

                        fetch(`/admin/users/${userId}/toggle-ban`, { method: 'PUT' })
                            .then(response => response.json())
                            .then(data => {
                                if (data.status === 'ACTIVE') {
                                    document.getElementById(`status-${userId}`).textContent = 'ACTIVE';
                                    btn.textContent = 'Ban';
                                    btn.classList.remove('btn-success');
                                    btn.classList.add('btn-danger');
                                } else if (data.status === 'BANNED') {
                                    document.getElementById(`status-${userId}`).textContent = 'BANNED';
                                    btn.textContent = 'Unban';
                                    btn.classList.remove('btn-danger');
                                    btn.classList.add('btn-success');
                                }
                            })
                            .catch(err => console.error('Error:', err));
                    });
                });
            })
            .catch(error => console.error('Error fetching users:', error));
    }

    fetchAndDisplayUsers();
});

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
                        <td id="status-${user.id}">${user.status}</td> 
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
                        const userId = btn.dataset.userId;

                        fetch(`/admin/users/${userId}/toggle-ban`, { method: 'PUT' })
                            .then(response => response.json())
                            .then(data => {
                                if (data.status === 'ACTIVE') {
                                    document.getElementById(`status-${userId}`).textContent = 'ACTIVE';
                                    btn.textContent = 'Ban';
                                    btn.classList.remove('btn-success');
                                    btn.classList.add('btn-danger');
                                } else if (data.status === 'BANNED') {
                                    document.getElementById(`status-${userId}`).textContent = 'BANNED';
                                    btn.textContent = 'Unban';
                                    btn.classList.remove('btn-danger');
                                    btn.classList.add('btn-success');
                                }
                            })
                            .catch(err => console.error('Error:', err));
                    });
                });
            })
            .catch(error => console.error('Error fetching users:', error));
    }

    fetchAndDisplayUsers();
});
