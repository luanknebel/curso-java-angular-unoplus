import { Injectable } from '@angular/core';
import { NotifierService } from 'angular-notifier';

@Injectable({
  providedIn: 'root'
})
export class NotifierHandlerService {

  private readonly SUCESS = 'success';
  private readonly WARNING = 'warning';
  private readonly ERROR = 'error';
  private readonly INFO = 'info';
  private readonly DEFAULT = 'default';
  private readonly notifierService: NotifierService;

  constructor(notifierService: NotifierService) {
    this.notifierService = notifierService;
  }

  notifySucess(message : string){
    this.notifierService.notify(this.SUCESS, message);
  }

  notifyWarning(message : string){
    this.notifierService.notify(this.WARNING, message);
  }

  notifyError(message : string){
    this.notifierService.notify(this.ERROR, message);
  }

  notifyInfo(message : string){
    this.notifierService.notify(this.INFO, message);
  }

  notify(message : string){
    this.notifierService.notify(this.DEFAULT, message);
  }
  
}

