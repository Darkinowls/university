<html>
@yield('head')
<header>
    <a href="/public" class="Logo">
        <img src="//localhost/public/img/header/logo.png" alt="El'Strauss" width="60px" height="60px"/>
        <div>
            <span id="Name">El'Strauss</span>
            <span id="Op">магазин електротранспорту</span>
        </div>
    </a>

    <div id="Bar" class="Bar">

        <div class="CategoryMenu">
            <div class="Category">
                Категорії
                <div class="arrow">
                    <div class="l1"></div>
                    <div class="l2"></div>
                </div>
            </div>


            <div class="CategoryDropped">
                <ul>
                    <li><a href="/public/category/1">Електротранспорт</a></li>
                    <li><a href="/public/category/2">Електроскутери</a></li>
                    <li><a href="/public/category/3">Електромотоцикли</a></li>
                    <li><a href="/public/category/4">Електротрицикли</a></li>
                </ul>
            </div>
        </div>

        <div class="ContactsMenu">
            <a href="#" class="Contacts">Контакти
                <div class="arrow">
                    <div class="l1"></div>
                    <div class="l2"></div>
                </div>
            </a>
            <div class="ContactsDropped">
                <div class="nums">
                    <div>Робочий час</div>
                    <div>9:00 - 21:00</div>
                </div>
                <div class="nums">
                    <div>+38(095) 72-43-822</div>
                    <div>+38(095) 72-43-824</div>
                </div>
            </div>
        </div>

        <div class="News" href="#">
            <a>Новини</a>
        </div>

        <div class="Icons">
            <a href="#" class="Basket">
                <img src="//localhost/public/img/header/basket.png" alt="Basket" width="50px" height="35px"/>
            </a>

            <a href="#" class="Acc">
                <img src="//localhost/public/img/header/account.png" alt="Account" width="35px" height="35px"/>
            </a>
            <div class="input">
                <label for="search"></label>
                <input type="text" id="search" placeholder="Search..." name="search">
                <button type="submit">
                    <img src="//localhost/public/img/header/search.png" height="25px" width="25px" alt="SearchIcon"/>
                </button>
            </div>
        </div>

    </div>

    <div id="Menu" onclick="ShowMenu()" class="Menu">
        <div class="l1"></div>
        <div class="disapear"></div>
        <div class="l2"></div>
    </div>

</header>

<main>
    @yield('content')

</main>

<footer>
    <div class="blockBlue"></div>
    <div class="blockOrange"></div>
    <div class="foot">
        <div class="Contacts">
            <div class="Nums">
                <p class="Big">Контакти</p>
                <p>+38(095) 72-43-822</p>
                <p>+38(095) 72-43-823</p>
            </div>
            <div class="Mails">
                <p>Email:</p>
                <p>BlackInOwls@gmail.com</p>
            </div>

        </div>
        <div class="Category">
            <div class="Big">Категорії</div>
            <ul class="Main">
                <li>
                    <div><a href="/public/category/1">Електротранспорти</a><span>22</span></div>
                </li>
            </ul>
            <ul>
                <li>
                    <div><a href="/public/category/2">Електроскутери</a><span>8</span></div>
                </li>
                <li>
                    <div><a href="/public/category/3">Електромотоцикли</a><span>8</span></div>
                </li>
                <li>
                    <div><a href="/public/category/4">Електротрицикли</a><span>6</span></div>
                </li>
            </ul>
            <ul class="Main">
                <li>
                    <div><a href="#">Аксесуари</a><span>10</span></div>
                </li>
            </ul>

        </div>
    </div>
</footer>
</html>



