    <tr style=&quot;background-color: black; color: white&quot;>        <th>Country</th>        <th>State</th>        <th>Total Cases</th>    </tr>    <tr th:each=&quot;data : ${stats}&quot;>        <td th:text=&quot;${data.country}&quot;></td>        <td th:text=&quot;${data.state}&quot;></td>        <td th:text=&quot;${data.latestTotalCases}&quot;>0</td>    </tr>