import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GraphQLModule } from './graphql.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NavbarComponent} from "./shared/navbar/navbar.component";
import {MaterialModule} from "./utils/material/material.module";
import {MDBBootstrapModule} from "angular-bootstrap-md";
import {FormsModule} from "@angular/forms";
import {LightboxModule} from "ngx-lightbox";
import {FooterComponent} from "./shared/footer/footer.component";
import {SharedModule} from "./shared/shared.module";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    GraphQLModule,
    SharedModule,
    LightboxModule,
    MaterialModule,
    MDBBootstrapModule.forRoot(),
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
