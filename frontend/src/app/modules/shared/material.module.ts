import { NgModule } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider'
import { MatButtonModule } from '@angular/material/button'
import { MatMenuModule } from '@angular/material/menu'
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatListModule } from '@angular/material/list'
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatTableModule } from '@angular/material/table'
import { MatTabsModule} from '@angular/material/tabs';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatInputModule } from '@angular/material/input'
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatNativeDateModule } from '@angular/material/core';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatSliderModule } from '@angular/material/slider';
import { MatDialogModule } from '@angular/material/dialog';

const materialModules = [
  MatDialogModule,
  MatTooltipModule,
  MatToolbarModule,
  MatIconModule,
  MatDividerModule,
  MatButtonModule,
  MatListModule,
  MatMenuModule,
  MatProgressBarModule,
  MatCardModule,
  MatRadioModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatTableModule,
  MatSelectModule,
  MatDatepickerModule,
  MatFormFieldModule,
  MatInputModule,
  MatTabsModule,
  MatSidenavModule,
  FlexLayoutModule,
  MatButtonToggleModule,
  MatSliderModule
]
@NgModule({
  imports: [
    FlexLayoutModule,
    ...materialModules
  ],
  exports: [
    FlexLayoutModule,
    ...materialModules
  ]
})
export class MaterialModule { }
