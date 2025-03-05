function setRootFontSize() {
    var screenWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
    var baseFontSize = screenWidth / 400; // 根据需要调整的比例来计算基准体大小
    document.documentElement.style.fontSize = baseFontSize + 'px';
  }
  
  // 页面加载完成时调用一次
  window.addEventListener('DOMContentLoaded', setRootFontSize);
  
  // 窗口大小改变时重新计算基准字体大小
  window.addEventListener('resize', setRootFontSize);