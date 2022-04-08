import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/service/product.service';
import { Product} from 'src/app/common/product';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-product-list',
  //templateUrl: './product-list.component.html',
  templateUrl: './product-list-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  productList:Product[] ;
  currentCategoryId: number;

  constructor(private service:ProductService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const hasCategoryId: boolean=this.route.snapshot.paramMap.has('id');
    if(hasCategoryId){
      this.currentCategoryId= +this.route.snapshot.paramMap.get('id');
    }else{
      this.currentCategoryId=2;
    }
    this.service.getProductList(this.currentCategoryId).subscribe((data) => {this.productList = data});
    
  }

}
