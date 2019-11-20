<#include "security.ftl">

<div>
    <div> Username : ${name}</div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Sign Out"/>
    </form>
</div>
<div>Пополнить баланс</div>
<form method="post" action="/myAccount/{user}"/>
      <input type="number" name="yourId" placeholder="введите свой id"/>
      <input type="number" name="money" placeholder="укажите сумму "/>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>

    <button type="submit">ПОПОЛНИТЬ</button>
</form>
<#list myinfo as myinfo>
    <b> ИМЯ : ${myinfo.username}</b>
    <b> БАЛАНС : ${myinfo.money}</b>
    <b> ВАШ id: ${myinfo.id}</b>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
<#else >
    no
</#list>


