import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product} from '../common/product';
import { map } from 'rxjs/Operators';
import { ProductCategory } from '../common/product-category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl='http://localhost:8080/api/products';
  private catUrl='http://localhost:8080/api/productCategorys'
  constructor (private http:HttpClient){ }
  getProductList(theCategoryId: number): Observable<Product[]>{
    const searchUrl =`${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`;
     return  this.http.get<GetResponse>(searchUrl).pipe(map(response=>response._embedded.products));
  }
  
getProductCategory(): Observable<ProductCategory[]>{

    return this.http.get<GetCategoryResponse>(this.catUrl).pipe(map(response=>response._embedded.productCategorys));
}
}

interface GetResponse{

  _embedded:{
    products:Product[];
  };
}

interface GetCategoryResponse{

  _embedded:{
    productCategorys:ProductCategory[];
  }

}

