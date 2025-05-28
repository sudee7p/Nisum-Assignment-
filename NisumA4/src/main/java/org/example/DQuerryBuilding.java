package org.example;

public List<Product> DQuerryBuilding(String category, Double minPrice, Double maxPrice) {
    List<Product> products = new ArrayList<>();
    StringBuilder sql = new StringBuilder("SELECT * FROM products WHERE 1=1");
    List<Object> params = new ArrayList<>();

    if (category != null) {
        sql.append(" AND category = ?");
        params.add(category);
    }
    if (minPrice != null) {
        sql.append(" AND price >= ?");
        params.add(minPrice);
    }
    if (maxPrice != null) {
        sql.append(" AND price <= ?");
        params.add(maxPrice);
    }

    try (Connection conn = DatabaseUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
        for (int i = 0; i < params.size(); i++) {
            pstmt.setObject(i + 1, params.get(i));
        }
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            products.add(new Product(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getDouble("price")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return products;
}
