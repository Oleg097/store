<#include "security.ftl">

<div>
    <div> Username : ${name}</div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign Out"/>
    </form>
</div>
<div>ПОПОЛНЕНИЕ БАЛАНСА И ПРОСМОТР ДАННЫХ</div>
<form method="post" action="/myAccount/{user}"/>
      <input type="number" name="yourId" placeholder="введите свой id"/>
      <input type="number" name="money" placeholder="укажите сумму "/>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>

    <button type="submit">ПОПОЛНИТЬ БАЛАНС</button>
</form>
<div>
<#list myinfo as myinfo>
    <div><b> ИМЯ : ${myinfo.username}</b></div>
    <div><b> БАЛАНС : ${myinfo.money}</b></div>
    <div><b> ВАШ id: ${myinfo.id}</b></div>

    <div><input type="hidden" name="_csrf" value="${_csrf.token}"/></div>
<#else >
   НЕ НАЙДЕНО ТОВАРОВ
</#list>
</div>
<div>
    <a href="/myBasket/${name}">МОЯ КОРЗИНА ТОВАРОВ</a>
</div>
<div>
    <a href="/main">К СПИСКУ ТОВАРОВ</a>
</div>



