Feature: Búsquedas en la página MDH

  Scenario Outline: Buscar articulo en la pagina mdh
    Given El usuario introduce "<busqueda>"
    When Pagina de resultados es mostrada
    Then El usario accede a los detalles del producto buscado

    Examples:
      | busqueda               |
      | M1 Helmet              |