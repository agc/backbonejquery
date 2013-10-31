class StaticPagesController < ApplicationController

  layout 'static_files', :only =>  'display'
  layout 'backbone_tutorial', :only =>  'backbone'
  def home
  end

  def help
  end

  def display

  end


    def display
      render params[:page] ##,:layout=>false
    end

  def backbone

        render params[:page]
  end
end
