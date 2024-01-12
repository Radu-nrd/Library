<header>
    <nav class="autohide navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container-fluid menumarginleft">
            <a class="navbar-brand large-text" href="${pageContext.request.contextPath}/Home">Library</a>
            <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#navbarColor02"
                    aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse serchbarmarginleft" id="navbarColor02">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <form class="search-form" action="AddBook" method="post">
                            <input type="text" class="search-bar" id="searchInput" placeholder="Enter your search term">
                            <button type="submit" class="search-button">Search</button>
                        </form>
                    </li>
                </ul>
                <div class="d-flex align-items-center">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 rightmarginmenu">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Items</a>
                        </li>
                        <!-- Dropdown -->
                        <li class="nav-item dropdown marginrightprofile">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                               data-mdb-toggle="dropdown" aria-expanded="false">
                                Profile
                            </a>
                            <ul class="dropdown-menu menu-width" aria-labelledby="navbarDropdownMenuLink">
                                <li>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/Profile">Profile</a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/Logout">Log Out</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</header>