<th:block th:each=&quot;data : ${stats}&quot;>    <tr>        <td th:text=&quot;${data.country}&quot;></td>        <td th:text=&quot;${data.state}&quot;></td>        <td th:text=&quot;${data.latestTotalCases}&quot;>0</td>    </tr></th:block>