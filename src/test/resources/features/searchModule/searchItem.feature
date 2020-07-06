Feature: Búsquedas en la página MDH

  Scenario: Buscar articulo en la pagina mdh
    Given El usuario introduce criterio de busqueda
    When Pagina de resultados es mostrada
    Then El usario accede a los detalles del producto buscado

