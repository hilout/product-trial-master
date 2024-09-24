import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { CartProduct, Product } from './product.model';


@Injectable({
    providedIn: 'root'
})
export class CartService {
    private cartUpdates = new BehaviorSubject<CartProduct[]>([]);
    private quantity = new BehaviorSubject(0);
    public cartUpdates$ = this.cartUpdates.asObservable();
    public quantity$ = this.quantity.asObservable();


    public cartItems:CartProduct[] =[];

    constructor() {
    }

    public getQuantity():Observable<number>{
        return this.quantity$
    };

    add(product:Product){
        let item:CartProduct = this.cartItems.find(item => item.id == product.id) as CartProduct ;
        if(item)
        { item.qty ++}
        else {
            (product as CartProduct).qty = 1;
            this.cartItems.push(product as CartProduct);
        }
        this.cartUpdates.next(this.cartItems);

        this.quantity.next(0);
        this.cartItems.forEach(item => this.quantity.next(this.quantity.value+item.qty));
        console.log('product added',product);
    }

    delete(product:Product){
        this.cartItems.splice(this.cartItems.findIndex(item => item.id == product.id),1);
        this.cartUpdates.next(this.cartItems);

        this.quantity.next(0);
        this.cartItems.forEach(item => this.quantity.next(this.quantity.value+item.qty));
        console.log('product deleted',product);
    }

    changeQuantity(product: CartProduct) {
        let item:CartProduct = this.cartItems.find(item => item.id == product.id) as CartProduct ;
        item.qty = product.qty;
        this.cartUpdates.next(this.cartItems);

        this.quantity.next(0);
        this.cartItems.forEach(item => this.quantity.next(this.quantity.value+item.qty));
        console.log('quantity',this.quantity);
        console.log('product updated',product);
    }
}