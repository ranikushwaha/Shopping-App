import 'package:flutter/material.dart';
import '../models/product.dart';

class ProductDetailScreen extends StatelessWidget {
  final Product product;
  const ProductDetailScreen({Key? key, required this.product}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // 🔹 Remove default AppBar, use custom container
      body: SingleChildScrollView(
        child: Column(
          children: [
            // 🔹 Custom AppBar
            Container(
              padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 15),
              decoration: const BoxDecoration(
                color: Color(0xFF1976D2),
                borderRadius: BorderRadius.only(
                  bottomLeft: Radius.circular(20),
                  bottomRight: Radius.circular(20),
                ),
              ),
              child: Row(
                  children: [
                    // Back button with top margin
                    Container(
                      margin: const EdgeInsets.only(top: 40), // adjust as needed
                      child: IconButton(
                        onPressed: () => Navigator.pop(context),
                        icon: const Icon(Icons.arrow_back, color: Colors.white),
                      ),
                    ),
                    const SizedBox(width: 8),
                    // Text with top margin
                    Container(
                      margin: const EdgeInsets.only(top: 40), // same top margin for alignment
                      child: Text(
                        product.category.toUpperCase(),
                        style: const TextStyle(
                          color: Colors.white,
                          fontSize: 18,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                  ],
              ),
            ),

            // 🔹 Product Content
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Center(
                    child: Hero(
                      tag: 'product_${product.id}',
                      child: Image.network(
                        product.image,
                        height: 220,
                        fit: BoxFit.contain,
                        errorBuilder: (c, e, s) =>
                        const Icon(Icons.broken_image, size: 80),
                      ),
                    ),
                  ),
                  const SizedBox(height: 16),
                  Text(
                    product.title,
                    style: const TextStyle(
                        fontSize: 18, fontWeight: FontWeight.bold),
                  ),
                  const SizedBox(height: 8),
                  Text(
                    '\$${product.price.toStringAsFixed(2)}',
                    style: const TextStyle(fontSize: 16, color: Colors.green),
                  ),
                  const SizedBox(height: 12),
                  Row(children: [
                    const Icon(Icons.star, color: Colors.orange, size: 18),
                    const SizedBox(width: 6),
                    Text('${product.rating.rate} (${product.rating.count})'),
                  ]),
                  const SizedBox(height: 16),
                  Text(product.description),
                  const SizedBox(height: 24),

                  // 🔹 Add to Cart Button (Blue text)
                  OutlinedButton.icon(
                    onPressed: () {},
                    icon: const Icon(Icons.add_shopping_cart,
                        color: Colors.blue),
                    label: const Text(
                      'Add to cart',
                      style: TextStyle(color: Colors.blue),
                    ),
                    style: OutlinedButton.styleFrom(
                      minimumSize: const Size.fromHeight(48),
                      side: const BorderSide(color: Colors.blue, width: 2),
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(12),
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
