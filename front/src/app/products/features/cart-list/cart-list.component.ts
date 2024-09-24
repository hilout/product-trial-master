import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { Observable} from 'rxjs';
import {
  MatDialog,
  MatDialogActions,
  MatDialogClose,
  MatDialogContent,
  MatDialogTitle
} from '@angular/material/dialog';
import { CartProduct, Product } from '../../data-access/product.model';
import { CartService } from '../../data-access/cart.service';
import { AsyncPipe, CurrencyPipe, NgForOf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatButton } from '@angular/material/button';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  standalone: true,
  imports: [
    MatDialogContent,
    AsyncPipe,
    CurrencyPipe,
    FormsModule,
    MatDialogActions,
    MatButton,
    MatDialogClose,
    MatDialogTitle,
    NgForOf
  ],
  styleUrl: './cart-list.component.scss'
})
export class CartListComponent implements OnInit {
  cartItems$: Observable<CartProduct[]> | undefined;
  // @ts-ignore
  @ViewChild('myDialog', { static: true }) myDialog: TemplateRef<any>;
  protected count$: Observable<any> | undefined;

  constructor(protected cartService:CartService,
              private dialog: MatDialog) {

    //this.cartService.getQuote().subscribe();
    this.cartService.getQuantity().subscribe();
  }

  ngOnInit() {
    this.cartItems$ = this.cartService.cartUpdates$;
    this.count$ = this.cartService.getQuantity();
  }

  async openCart():Promise<void> {
    this.dialog.open(this.myDialog);
  }

  protected removeProduct(item: Product) :void{
    this.cartService.delete(item);
  }

  protected chngQuantity(product: any):void{
    console.log('product',product);
    this.cartService.changeQuantity(product);
  }


}
