document.addEventListener("DOMContentLoaded", function () {
    const tableBody = document.querySelector("#usersTable tbody");
    const roleFilter = document.getElementById("roleFilter");

    function fetchAndDisplayUsers(role = "") {
        let url = "/admin/users";
        if (role) url += `?role=${role}`;

        fetch(url)
            .then(res => res.json())
            .then(users => {
                tableBody.innerHTML = "";
                if (users.length === 0) {
                    tableBody.innerHTML = "<tr><td colspan='6'>No users found.</td></tr>";
                    return;
                }

                users.forEach(user => {
                    const row = document.createElement("tr");
                    row.innerHTML = `
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.role}</td>
                        <td>${user.status}</td>
                        <td>
                            <button class="btn btn-danger btn-sm toggle-ban" data-user-id="${user.id}">
                                ${user.status === 'BANNED' ? 'Unban' : 'Ban'}
                            </button>
                        </td>
                    `;
                    tableBody.appendChild(row);
                });

                document.querySelectorAll(".toggle-ban").forEach(btn => {
                    btn.addEventListener("click", () => {
                        const userId = btn.dataset.userId;
                        fetch(`/admin/users/${userId}/toggle-ban`, { method: "PUT" })
                            .then(() => fetchAndDisplayUsers(roleFilter.value));
                    });
                });
            })
            .catch(() => {
                tableBody.innerHTML = "<tr><td colspan='6'>Error loading users.</td></tr>";
            });
    }

    fetchAndDisplayUsers();
    roleFilter.addEventListener("change", () => fetchAndDisplayUsers(roleFilter.value));
});
