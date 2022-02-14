import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FooterComponent } from 'src/app/modules/shared/components/footer/footer.component';
import { HeaderComponent } from 'src/app/modules/shared/components/header/header.component';
import { SidebarComponent } from 'src/app/modules/shared/components/sidebar/sidebar.component';
import { SharedModule } from 'src/app/modules/shared/shared.module';
import { MainComponent } from './main.component';



@NgModule({
  declarations: [
    MainComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule
  ],
  providers: [
  ]
})
export class MainModule { }
