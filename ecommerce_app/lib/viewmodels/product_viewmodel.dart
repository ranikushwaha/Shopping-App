import 'package:flutter/material.dart';

import '../models/product.dart';
import '../services/api_service.dart';

class ProductViewModel extends ChangeNotifier {
  final ApiService apiService;
  List<Product> products = [];
  bool isLoading = false;
  String? error;


  ProductViewModel({required this.apiService});


  Future<void> loadProducts() async {
    try {
      isLoading = true;
      error = null;
      notifyListeners();
      products = await apiService.fetchProducts();
    } catch (e) {
      error = e.toString();
    } finally {
      isLoading = false;
      notifyListeners();
    }
  }
}