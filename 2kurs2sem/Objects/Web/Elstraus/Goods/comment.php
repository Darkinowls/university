
<div class="title">Коментарі</div>
<div class="bLine">
    <button class="button">Переглянути всі</button>
    <button class="button" onclick="showPop()">Залишити відгук</button>
</div>

<div id="pop">
    <img src="Imgs\closer.png" class="closer" onclick="showPop()">
    <form method="post">
        <div>Введіть відгук</div>
        <br/>
        <input type="text" name="name" placeholder="Ім'я"
               value="<? echo htmlspecialchars($_POST['name'] ?? $_COOKIE['userName'] )?>"/><br/>
        <input type="email" name="email" placeholder="Почта (необов'язково)"/><br/>
        <textarea name="text" placeholder="Введіть ваш коментар ..." rows="5" cols="30"></textarea><br/>
        <button class="button">Відправити</button>
    </form>
</div>

